package example.model.singleton;

import example.model.entity.Conversation;

public class SelectedConversation {
    private static SelectedConversation _instance;
    private Conversation currentConversation;
    private String currentFilename;

    private SelectedConversation(Conversation conversation, String filename){
        currentConversation=conversation;
        currentFilename=filename;
    }

    public static SelectedConversation getInstance(){
        return _instance;
    }

    public static void getInstance(Conversation conversationToUse,String filename){
        _instance=new SelectedConversation(conversationToUse,filename);
    }

    public static void closeSession(){
        _instance=null;
    }

    public Conversation getCurrentConversation() {
        return currentConversation;
    }

    public String getCurrentFilename() {
        return currentFilename;
    }
}
