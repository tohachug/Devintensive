package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16): String{
    var res = this.trim()
    return if(res.length > value){
        res.substring(0, value).dropLastWhile{it == ' '}.plus("...")
    } else{
        res
    }
}

fun String.stripHtml(): String{
    var result = this.replaceRange(this.indexOf("<"), this.indexOf(">")+1, "")
            .replace("&","")
            .replace("'","")
            .replace("""""","")
    while (result.contains("<") && result.contains(">")){
        result = result.replaceRange(result.indexOf("<"), result.indexOf(">")+1, "")
    }
    while(result.contains("  "))
        result = result.replace("  "," ")
    return result
}