//create new doGet() function which handles GET request from client
function doGet(e){

  var result = {};

  var protein = SpreadsheetApp.openByUrl("https://docs.google.com/spreadsheets/d/1Ed_B8v0ZVNtstaj9Eec6iViBEe3IxBWElJU3uSuFPYY/edit#gid=2024304766")
  .getSheetByName('protein')
  .getDataRange()
  .getValues();

  var keys = protein.shift();

  result.protein = getObjects(protein,keys)

  return ContentService.createTextOutput(JSON.stringify(result)).setMimeType(ContentService.MimeType.JSON);

}

// For every row of data in data, generates an object that contains the data. Names of
// object fields are defined in keys.
// Arguments:
//   - data: JavaScript 2d array
//   - keys: Array of Strings that define the property names for the objects to create

function getObjects(data, keys) {
  var objects = [];
  for (var i = 0; i < data.length; ++i) {
    var object = {};
    var hasData = false;
    for (var j = 0; j < data[i].length; ++j) {
      var cellData = data[i][j];
      if (isCellEmpty_(cellData)) {
        continue;
      }
      object[keys[j]] = cellData;
      hasData = true;
    }
    if (hasData) {
      objects.push(object);
    }
  }
  return objects;
}

// Returns true if the cell where cellData was read from is empty.
// Arguments:
//   - cellData: string
function isCellEmpty_(cellData) {
  return typeof(cellData) == "string" && cellData == "";
}
