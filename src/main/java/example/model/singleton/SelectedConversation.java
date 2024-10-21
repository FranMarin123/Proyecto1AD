package example.model.singleton;

import example.model.entity.Conversation;

public class SelectedConversation {
    private static SelectedConversation _instance;
    private Conversation currentConversation;

    private SelectedConversation(Conversation conversation){
        currentConversation=conversation;
    }

    public static SelectedConversation getInstance(){
        return _instance;
    }

    public static void getInstance(Conversation conversationToUse){
        _instance=new SelectedConversation(conversationToUse);
    }

    public static void closeSession(){
        _instance=null;
    }

    public Conversation getCurrentConversation() {
        return currentConversation;
    }
}
