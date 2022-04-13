package ChatServiceTests

import ChatService
import Message
import org.junit.Assert.*
import org.junit.Test

class ChatService_getUnreadChatsCount {
    @Test
    fun getUnreadChatsCount() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val message = Message(chatId = 1, fromUserId = 1, text = "Hello")
        val message2 = Message(chatId = 1, fromUserId = 1, text = "Hello Looser")
        chatService.createChat(listOfUsersId)
        chatService.addMessage(message)
        chatService.addMessage(message2)

        val expected = 1
        val actual = chatService.getUnreadChatsCount(2)

        assertEquals(expected, actual)
    }
}