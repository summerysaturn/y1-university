function main(val) {
  switch (val) {
    case 1:
      questionOne(val);
      break;
    case 2:
      questionTwo(val);
      break;
    default:
      break;
  }
}

function mulValues(a, b) {
  return a * b;
}

function questionOne(val) {
  domainLog(val, "354 * 875 = " + mulValues(354, 875));
  domainLog(val, "9876.543 * 765.123 = " + mulValues(9876.543, 765.123));
  domainLog(val, "1 = " + mulValues(1));
  domainLog(val, "1 * 2 * 3 = " + mulValues(1, 2, 3));
  domainLog(val, "Multiplying a value by undefined makes it become NaN");
  domainLog(
    val,
    "Extra parameters are dropped. This can be countered using ..."
  );
  domainLog(
    val,
    "undefined is where a variable is initialised but not assigned to."
  );
  domainLog(
    val,
    "NaN is a number that contains no numeric information (i.e. string assignment)"
  );
}

function countChar(c, s) {
  let counter = 0;
  for (let i = 0; i < s.length; i++) {
    const element = s.charAt(i);
    if (element.toUpperCase() == c.toUpperCase()) {
      counter++;
    }
  }
  return counter;
}

function questionTwo(val) {
  domainLog(val, `countChar("l", "hello"): ` + countChar("l", "hello"));
}

function domainLog(destination, string) {
  console.log(string);
  document.getElementById("out-" + destination).innerHTML += string + `\n`;
}
