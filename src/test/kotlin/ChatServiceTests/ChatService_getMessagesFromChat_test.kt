package ChatServiceTests

import ChatService
import Message
import org.junit.Assert.*
import org.junit.Test

class ChatService_getMessagesFromChat_test {
    @Test
    fun getMessagesFromChat() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val message = Message(chatId = 1, fromUserId = 1, text = "Hello")
        val message2 = Message(chatId = 1, fromUserId = 1, text = "Hello Looser")
        chatService.createChat(listOfUsersId)
        chatService.addMessage(message)
        chatService.addMessage(message2)

        val expected = listOf<Message>(
            message.copy(messageId = 1, isIncoming = true, isRead = true),
            message2.copy(messageId = 2, isIncoming = true, isRead = true)
        )
        val actual = chatService.getMessagesFromChat(userId = 2, chatId = 1)

        assertEquals(expected, actual)
    }
}