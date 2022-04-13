package ChatServiceTests

import Chat
import ChatService
import Message
import org.junit.Assert.*
import org.junit.Test

class ChatService_add_message_test_test {
    @Test
    fun addMessageTest_true() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val message = Message(chatId = 1, fromUserId = 1, text = "Hello")
        chatService.createChat(listOfUsersId)

        val expected = true
        val actual = chatService.addMessage(message)

        assertEquals(expected,actual)
    }
    @Test
    fun addMessageTest_false() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val message = Message(chatId = 999, fromUserId = 1, text = "Hello")
        chatService.createChat(listOfUsersId)

        val expected = false
        val actual = chatService.addMessage(message)

        assertEquals(expected,actual)
    }
}