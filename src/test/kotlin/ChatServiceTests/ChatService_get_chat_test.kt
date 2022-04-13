package ChatServiceTests
import Chat
import ChatService
import org.junit.Assert.*
import org.junit.Test

class ChatService_get_chat_test {
    @Test
    fun getChatTest() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val expectedChat = listOf(Chat(id = 1, users = listOfUsersId))
        chatService.createChat(listOfUsersId)
        val actualChat = chatService.getChats(1)

        assertEquals(expectedChat,actualChat)
    }
}