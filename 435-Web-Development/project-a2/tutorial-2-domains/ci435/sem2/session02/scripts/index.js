function main() {
  var a = 5;
  domainLog(a);
  var b = 3;
  domainLog(a * b);
  domainLog(a + (b % 3));

  var s1 = "Hello";
  var s2 = "Charlotte";

  domainLog(s1 + s2);
  domainLog(s1 + " " + s2);

  domainLog(a + " squared is " + a * a);
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
