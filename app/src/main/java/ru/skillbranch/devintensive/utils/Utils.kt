package ru.skillbranch.devintensive.utils

import android.icu.text.Transliterator
import android.os.Build
import android.service.autofill.Validators.not
import androidx.annotation.RequiresApi

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{

        val parts: List<String>? = fullName?.split(" ")
        val firstName = if(parts?.getOrNull(0)=="") null else parts?.getOrNull(0)
        val lastName = if(parts?.getOrNull(1)=="") null else parts?.getOrNull(1)

        return Pair(firstName, lastName)
    }

  //  @RequiresApi(Build.VERSION_CODES.Q)
    fun transliteration(divider: String = ""): String{
        var latinString: String = ""
//        val cirilicToLatin: String = "Cyrillic-Latin"
//        val transliterator = Transliterator.getInstance(cirilicToLatin)
//        val result: String = transliterator.transliterate(divider)
        for(it in divider){
              when(it.toString()){
                "а" -> latinString = latinString + "a"
                "б" -> latinString = latinString + "b"
                "в" -> latinString = latinString + "v"
                "г" -> latinString = latinString + "g"
                "д" -> latinString = latinString + "d"
                "е" -> latinString = latinString + "e"
                "ё" -> latinString = latinString + "e"
                "ж" -> latinString = latinString + "zh"
                "з" -> latinString = latinString + "z"
                "и" -> latinString = latinString + "i"
                "й" -> latinString = latinString + "i"
                "к" -> latinString = latinString + "k"
                "л" -> latinString = latinString + "l"
                "м" -> latinString = latinString + "m"
                "н" -> latinString = latinString + "n"
                "о" -> latinString = latinString + "o"
                "п" -> latinString = latinString + "p"
                "р" -> latinString = latinString + "r"
                "с" -> latinString = latinString + "s"
                "т" -> latinString = latinString + "t"
                "у" -> latinString = latinString + "u"
                "ф" -> latinString = latinString + "f"
                "х" -> latinString = latinString + "h"
                "ц" -> latinString = latinString + "c"
                "ч" -> latinString = latinString + "ch"
                "ш" -> latinString = latinString + "sh"
                "щ" -> latinString = latinString + "sh'"
                "ъ" -> latinString = latinString + ""
                "ы" -> latinString = latinString + "i"
                "ь" -> latinString = latinString + ""
                "э" -> latinString = latinString + "e"
                "ю" -> latinString = latinString + "yu"
                "я" -> latinString = latinString + "ya"
                "А" -> latinString = latinString + "A"
                "Б" -> latinString = latinString + "B"
                "В" -> latinString = latinString + "V"
                "Г" -> latinString = latinString + "G"
                "Д" -> latinString = latinString + "D"
                "Е" -> latinString = latinString + "E"
                "Ё" -> latinString = latinString + "E"
                "Ж" -> latinString = latinString+ "ZH"
                "З" -> latinString = latinString + "Z"
                "И" -> latinString = latinString + "I"
                "Й" -> latinString = latinString + "I"
                "К" -> latinString = latinString + "K"
                "Л" -> latinString = latinString + "L"
                "М" -> latinString = latinString + "M"
                "Н" -> latinString = latinString + "N"
                "О" -> latinString = latinString + "O"
                "П" -> latinString = latinString + "P"
                "Р" -> latinString = latinString + "R"
                "С" -> latinString = latinString + "S"
                "Т" -> latinString = latinString + "T"
                "У" -> latinString = latinString + "U"
                "Ф" -> latinString = latinString + "F"
                "Х" -> latinString = latinString + "H"
                "Ц" -> latinString = latinString + "C"
                "Ч" -> latinString = latinString + "CH"
                "Ш" -> latinString = latinString + "SH"
                "Щ" -> latinString = latinString + "SH'"
                "Ъ" -> latinString = latinString + ""
                "Ы" -> latinString = latinString + "I"
                "Ь" -> latinString = latinString + ""
                "Э" -> latinString = latinString + "E"
                "Ю" -> latinString = latinString + "YU"
                "Я" -> latinString = latinString + "YA"
                else -> latinString = latinString + it
            }
        }
        return latinString
    }

  fun toInitials(firstName: String?, lastName: String?): String?{
    var result: String? = null
    if (firstName?.isNullOrBlank() == false){
        result = firstName?.get(0).toString().toUpperCase()
    }
    if(lastName?.isNullOrBlank() == false){
      result = result + lastName?.get(0).toString().toUpperCase()
    }
    return result
  }
}