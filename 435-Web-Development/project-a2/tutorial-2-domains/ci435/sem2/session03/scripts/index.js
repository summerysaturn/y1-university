function main() {
  domainLog("1 == true:");
  domainLog(1 == true);
  domainLog("1 === true:");
  domainLog(1 === true);

  var x = 3;
  var y = 5;

  domainLog("x <= y :");
  domainLog(x <= y);
  domainLog("x > 4 && y > :");
  domainLog(x > 4 && y > 4);
  domainLog("x > 4 || y > :");
  domainLog(x > 4 || y > 4);
  domainLog("!(x > 4 || y > 4) :");
  domainLog(!(x > 4 || y > 4));
  domainLog("x != y && y > 0 :");
  domainLog(x != y && y > 0);
  domainLog("x * y < 15 :");
  domainLog(x * y < 15);
  domainLog("x * y <= 15 :");
  domainLog(x * y <= 15);

  if (x > y) {
    domainLog("x is greater than y");
  } else {
    domainLog("x is less than or equal to y");
  }

  if (x > y) {
    domainLog(x / y);
  }

  while (y < 100) {
    y += x;
  }
  domainLog(y);

  // this is messy af
  for (let i = 0; i < y; i++) {
    domainLog(y);
  }

  var day = Math.floor(Math.random() * 7);

  switch (day) {
    case 0:
      domainLog("the generated day was Monday");
      break;
    case 1:
      domainLog("the generated day was Tuesday");
      break;
    case 2:
      domainLog("the generated day was Wednesday");
      break;
    case 3:
      domainLog("the generated day was Thursday");
      break;
    case 4:
      domainLog("the generated day was Friday");
      break;
    case 5:
      domainLog("the generated day was Saturday");
      break;
    case 6:
      domainLog("the generated day was Sunday");
      break;
    default:
      domainLog("this message shouldn't appear");
      break;
  }

  domainLog("\n");
}

/* outputs
 * 5                   index.js:3:11
 * 15                  index.js:5:11
 * 5                   index.js:6:11
 * HelloCharlotte      index.js:11:11
 * Hello Charlotte     index.js:12:11
 * 5 squared is 25     index.js:14:11
 */

function domainLog(string) {
  console.log(string);
  document.getElementById("outbox").innerHTML +=
    "<code>" + string + "</code>\n";
}
