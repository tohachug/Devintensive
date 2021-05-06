package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2", "John", "Week")
        val user3 = User("3", "John", "Silver", null, lastVisit = Date(), isOnline = true)
        val user4 = User.makeUser("Toha chug")

        val user5 = User.Builder()
            .id("1")
            .firstName("toha")
            .lastName("chug")
            .avatar(null)
            .rating(1)
            .respect()
            .lastVisit(Date())
            .isOnline(true)
            .build()
        //  user.printMe()
        //  user2.printMe()
        //  user3.printMe()
        //  user4.printMe()
        user5.printMe()

        //Println("$user $user2 $user3")

        //        Date.humanizeDiff ошибка
//        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff()) //null null
//        println(Date().add(-5, TimeUnits.DAY).humanizeDiff()) //null null
//        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //null null
//        println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //null null
//        println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //null null
//        println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //null null
    }

    @Test
    fun String_toInitials(){
        println(Utils.toInitials("john" ,"doe")) //null null
        println(Utils.toInitials("John", null) ) //null null
        println(Utils.toInitials(null, null)) //null null
        println(Utils.toInitials(" ", "")) //null null
    }

    @Test
    fun Date_humanizeDiff(){
        //  println(Date().add(-2, TimeUnits.SECOND).humanizeDiff()) //null null
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff()) //null null
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff()) //null null
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //null null
        println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //null null
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //null null
        println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //null null
    }

    @Test
    fun String_plural(){
        println(TimeUnits.SECOND.plural(2)) //null null
        println(TimeUnits.MINUTE.plural(4)) //null null
        println(TimeUnits.HOUR.plural(19)) //null null
        println(TimeUnits.DAY.plural(222)) //null null

    }

    @Test
    fun String_truncate(){
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate()) //null null
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) ) //null null
        println("A     ".truncate(3)) //null null
    }

    @Test
    fun stripHtml(){
        println("<p class=title>Образовательное IT-сообщество Skill Branch</p>".stripHtml()) //null null
        println("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml()) //null null
    }

}