/*
 * Title: Integer to Roman Numerals
 * Author: Sam Gavis-Hughson
 * Date: 29/08/2019
 * 
 * Write a function to convert an integer into its roman numeral representation
 * 
 * Execution: php php\IntToRoman.php
 * 
 * For more details, check out http://www.byte-by-byte.com/inttoroman/
 */

<?php

class IntToRoman
{
	public static function integerToRoman(int $integer)
	{
		$result = '';
		$lookup = array(
			'M' => 1000,
		    'CM' => 900,
		    'D' => 500,
		    'CD' => 400,
		    'C' => 100,
		    'XC' => 90,
		    'L' => 50,
		    'XL' => 40,
		    'X' => 10,
		    'IX' => 9,
		    'V' => 5,
		    'IV' => 4,
		    'I' => 1,
		  );
		foreach($lookup as $roman => $value)
	    {
	      $matches = intval($integer/$value);
	      
	      $result .= str_repeat($roman, $matches);
	      
	      $integer = $integer % $value;
	    }

	    return $result;
	}
}

echo IntToRoman::integerToRoman(1)."\n";
echo IntToRoman::integerToRoman(4)."\n";
echo IntToRoman::integerToRoman(49)."\n";

?>