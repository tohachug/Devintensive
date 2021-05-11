package ru.skillbranch.devintensive.models

class Bender(var status: Status = Status.NORMAL, var questions: Questions = Questions.NAME) {

    fun askQuestions(): String = when(questions){
        Questions.NAME -> Questions.NAME.question
        Questions.PROFESSION -> Questions.PROFESSION.question
        Questions.MATERIAL -> Questions.MATERIAL.question
        Questions.BDAY -> Questions.BDAY.question
        Questions.SERIAL -> Questions.SERIAL.question
        Questions.IDLE -> Questions.IDLE.question
    }

    fun listenAnswer(answer: String): Pair<String, Triple<Int, Int, Int>>{

        return if(questions.answer.contains(answer)){
            questions = questions.nextQuestion()
            "Отлично - ты справился\n${questions.question}" to status.color
        }
        else{
            status = status.nextStatus()
            "Это не правильный ответ\n" +
                    "${questions.question}" to status.color
        }
    }

    enum class Status(val color: Triple<Int,Int,Int>) {
        NORMAL(Triple(255, 255, 255)) ,
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 0, 0));

        fun nextStatus() :Status{
            return if (this.ordinal < values().lastIndex){
                values()[this.ordinal + 1]
            }
            else{
                values()[0]
            }
        }
    }

    enum class Questions(val question: String, val answer: List<String>){

        NAME("Как меня зовут?", listOf("Бендер", "bender")) {
            override fun nextQuestion(): Questions = PROFESSION
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender")) {
            override fun nextQuestion(): Questions = MATERIAL
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")) {
            override fun nextQuestion(): Questions = BDAY
        },
        BDAY("Когда меня создали?", listOf("2993")) {
            override fun nextQuestion(): Questions = SERIAL
        },
        SERIAL("Мой серийный номер?", listOf("2716057")) {
            override fun nextQuestion(): Questions = IDLE
        },
        IDLE("На этом все, вопросов больше нет", listOf()) {
            override fun nextQuestion(): Questions = IDLE
        };

        abstract fun nextQuestion(): Questions
    }
}