function countOccurances(sentence, word) {
    let pattern = "\\b" + word + "\\b";
    let regex = new RegExp(pattern, "gi");
    let matches = sentence.match(regex);
    return matches.length;
}


console.log(countOccurances('The waterfall was so high, that the child couldn’t see its peak.',
'the'));