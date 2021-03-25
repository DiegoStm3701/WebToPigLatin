# WebToPigLatin
Program translates the contents of any html file to PigLatin

1) Command structure
  The program should take its input information through two command line parameters. The usage format is:
    java WebToPigLatin inputFile outputFile
  Example:
    java WebToPigLatin page1.html pigpage1.html
  In the above example, the input page is page1.html. The results should be written to the file pigpage1.html.
  If the command to the program is given incorrectly, print out a usage message like:

  Usage: java WebToPigLatin inputFile outputFile
  Must have two command-line parameters and abort.

2) Pig-Latin rules
  1. A word to be translated is a consecutive sequence of letters (a-z, A-Z) or apostrophes (must start with a letter), containing at least one vowel (or y in a vowel position).
      Examples: Zebra , doesn't , apple, rhythm
  3. If a word starts with a vowel, the Pig Latin version is the original word with "way" added to the end
  4. If a word starts with a consonant, or a series of consecutive consonants, the Pig Latin version transfers all consonants up to the first vowel to the end of the word, and           adds "ay" to the end.
  5. The letter 'y' should be treated as a consonant if it is the first letter of a word, but treated as a vowel otherwise.
  6. If the original word is capitalized, the new Pig Latin version of the word should be capitalized in the first letter (i.e. the previous capital letter may not be                  capitalized any more).

3) File handling rules
  For the purposes of translating only the CONTENT of an html file (i.e. a web page), please observe the following requirements:
  Anything that appears inside of html tags is not content, so it should not be converted. Example:
  <font size="-1" face="Arial, Helvetica, sans-serif">Yadda Yadda</font>
  In this tag, only "Yadda Yadda" is content. The rest is not translated.
 
  Any item that fits the pattern of &text; is not content. These are special html markers for placing symbols like quotes and ampersands, that otherwise have special meaning to    browsers. Example:
    &nbsp;Hello there		// only "Hello there" is content
  &quote;Hello there&quote;	// only "Hello there" is content
  Do not consider punctuation (other than apostrophes) to be parts of words (i.e. they should not be part of word translations). Punctuation will still appear in the content in    the appropriate places, after translation. Example:
    The attentive, brilliant Java student's friend was happy.
  translates to
   Ethay attentiveway, illiantbray Avajay udent'sstay iendfray asway appyhay.
  Numbers on web pages are obviously not translatable, so leave them as-is.
 
  Abbreviations with no vowels in them are not translatable, so leave them as-is.
 
  Anything from the html file that is not translated to Pig Latin should still appear in the file as-is. i.e. the intent is that the resulting web page should still appear the     same as the original, simply with all of the content words converted to Pig Latin.
