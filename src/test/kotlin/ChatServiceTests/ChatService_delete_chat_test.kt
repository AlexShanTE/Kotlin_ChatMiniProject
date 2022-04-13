package ChatServiceTests
import Chat
import ChatService
import org.junit.Assert.*
import org.junit.Test

class ChatService_delete_chat_test {
    @Test
    fun deleteChatTest_true() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val expected = true

        chatService.createChat(listOfUsersId)
        val actual = chatService.deleteChat(1)

        assertEquals(expected, actual)
    }
    @Test
    fun deleteChatTest_false() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2)
        val expected = false

        chatService.createChat(listOfUsersId)
        val actual = chatService.deleteChat(999)

        assertEquals(expected, actual)
    }
}