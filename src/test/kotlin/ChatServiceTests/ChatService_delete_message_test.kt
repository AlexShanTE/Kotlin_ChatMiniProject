package ChatServiceTests

import Chat
import ChatService
import Message
import org.junit.Assert.*
import org.junit.Test

class ChatService_delete_message_test {
    @Test
    fun deleteMessageTest_true() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val message = Message(chatId = 1, fromUserId = 1, text = "Hello")
        chatService.createChat(listOfUsersId)
        chatService.addMessage(message)

        val expected = true
        val actual = chatService.deleteMessage(message.copy(messageId = 1))

        assertEquals(expected, actual)
    }

    @Test
    fun deleteMessageTest_false() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val message = Message(chatId = 1, fromUserId = 1, text = "Hello")
        chatService.createChat(listOfUsersId)
        chatService.addMessage(message)

        val expected = false
        val actual = chatService.deleteMessage(message.copy(messageId = 999))

        assertEquals(expected, actual)
    }
}