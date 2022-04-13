  data class Chat (
    val id:Int,
    val users: MutableList<Int> = mutableListOf(),
    val messages: MutableList<Message> = mutableListOf()
)

