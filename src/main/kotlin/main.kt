fun main() {
    val chatService = ChatService()
    val listOfUsersId = mutableListOf(1, 2)
    val listOfUsersId2 = mutableListOf(2, 3)
    chatService.createChat(listOfUsersId)
    chatService.createChat(listOfUsersId2)

    var message = Message(chatId = 1, fromUserId = 1, text = "Hi")
    var message2 = Message(chatId = 1, fromUserId = 1, text = "Hello user 2")
    var message3 = Message(chatId = 2, fromUserId = 1, text = "Hello user 1")

    chatService.addMessage(message)
    chatService.addMessage(message2)
    chatService.addMessage(message3)

    println("Chat for user 1")
    println(chatService.getChats(1))
    println("Chat for user 2")
    println(chatService.getChats(2))

    println(chatService.getUnreadChatsCount(2))
    println(chatService.getUnreadMessagesCount(2))


}