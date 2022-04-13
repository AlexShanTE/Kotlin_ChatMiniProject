data class Message(
    val chatId: Int ,
    var text: String ,
    val fromUserId: Int,
    val messageId: Int = 0,
    val isOutgoing: Boolean = false,
    val isIncoming: Boolean = false,
    var isRead: Boolean = true
)
