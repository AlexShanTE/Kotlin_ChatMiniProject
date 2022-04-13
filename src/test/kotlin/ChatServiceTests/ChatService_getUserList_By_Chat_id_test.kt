package ChatServiceTests

import ChatService
import Message
import org.junit.Assert.*
import org.junit.Test

class ChatService_getUserList_By_Chat_id_test {
    @Test
    fun getUserListByChatId() {
        val chatService = ChatService()
        chatService.chatList.clear()
        val listOfUsersId = mutableListOf(1, 2,3)
        chatService.createChat(listOfUsersId)

        val expected = listOf(1,2,3)
        val actual = chatService.getUserListByChatId(1)

        assertEquals(expected, actual)
    }
}