class ChatService {
    val chatList: MutableMap<Int, MutableList<Chat>> = mutableMapOf()
    var chatId = 1
    var messageId = 1

    fun createChat(users: MutableList<Int>) {
        for (user in users) {
            chatList.addNewChat(user, Chat(chatId, users))
        }
        chatId++
    }

    fun getChats(userId: Int): MutableList<Chat>? {
        return chatList[userId]
    }

    fun deleteChat(chatId: Int): Boolean? {
        var res: Boolean? = false
        val listOfChatUsers = getUserListByChatId(chatId)
        if (listOfChatUsers != null) {
            for (user in listOfChatUsers) {
                res = chatList[user]?.removeIf { it.id == chatId }
            }
        }
        return res
    }

    fun addMessage(message: Message): Boolean? {
        var res: Boolean? = false
        val listOfChatUsers = getUserListByChatId(message.chatId)
        if (listOfChatUsers != null) {
            for (user in listOfChatUsers) {
                if (user == message.fromUserId) {
                    res = chatList[user]?.find { it.id == message.chatId }?.messages?.add(
                        message.copy(
                            messageId = messageId,
                            isOutgoing = true,
                            isRead = true
                        )
                    )
                } else {
                    res = chatList[user]?.find { it.id == message.chatId }?.messages?.add(
                        message.copy(
                            messageId = messageId,
                            isIncoming = true,
                            isRead = false
                        )
                    )
                }
            }
            messageId++

        }
        return res
    }

    fun deleteMessage(message: Message): Boolean? {
        var res: Boolean? = false
        val listOfChatUsers = getUserListByChatId(message.chatId)
        if (listOfChatUsers != null) {
            for (user in listOfChatUsers) {
                res =
                    chatList[user]?.find { chat -> chat.id == message.chatId }?.messages?.removeIf { it.messageId == message.messageId }
            }

        }
        return res
    }

    fun editMessage(message: Message) {
        val listOfChatUsers = getUserListByChatId(message.chatId)
         if (listOfChatUsers != null) {
            for (user in listOfChatUsers) {
                chatList[user]?.
                find { chat -> chat.id == message.chatId }?.messages?.
                find { it.messageId == message.messageId }?.text = message.text
            }
        }
    }

    fun getMessagesFromChat(userId: Int, chatId: Int): MutableList<Message>? {
        return chatList[userId]?.find { it.id == chatId }?.messages?.onEach { it.isRead = true }
    }

    /**
    calculate count of all messages from all chats that's still not read
     */
    fun getUnreadMessagesCount(userId: Int): Int {
        var unreadMessages: Int = 0
        val userChats = chatList[userId]
        if (userChats != null) {
            for (chat in userChats) {
                unreadMessages += chat.messages.count { !it.isRead }
            }
        }
        return unreadMessages
    }

    fun getUnreadChatsCount(userId: Int): Int {
        var unreadChats: Int = 0
        val userChats = chatList[userId]
        if (userChats != null) {
            for (chat in userChats) {
                if (chat.messages.count { !it.isRead } != 0) unreadChats++
            }
        }
        return unreadChats
    }

    fun getUserListByChatId(chatId: Int): MutableList<Int>? {
        var res: MutableList<Int>?
        for (chat in chatList) {
            res = chat.value.find { it.id == chatId }?.users
            if (res !== null) {
                return res
            }
        }
        return null
    }
}


private fun <K> MutableMap<K, MutableList<Chat>>.addNewChat(key: K, chat: Chat) {
    if (this.keys.contains(key)) {
        this[key]?.add(chat)
    } else {
        this[key] = mutableListOf(chat)
    }
}














