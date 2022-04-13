package ChatServiceTests

import Chat
import ChatService
import org.junit.Assert.*
import org.junit.Test

class ChatService_create_chat_test {
    @Test
    fun createChatTest() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val expectedChat = listOf(Chat(id = 1, users = listOfUsersId))
        chatService.createChat(listOfUsersId)
        val actualChat = chatService.chatList[1]

        assertEquals(expectedChat,actualChat)
    }
}