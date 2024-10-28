package example.model.singleton;

import example.model.entity.Conversation;

/**
 * Singleton class that manages the currently selected conversation.
 * Ensures only one instance exists, representing the current conversation in focus.
 */
public class SelectedConversation {
    private static SelectedConversation _instance;
    private Conversation currentConversation;
    private String currentFilename;

    /**
     * Private constructor to prevent direct instantiation, ensuring singleton pattern.
     *
     * @param conversation The conversation to initialize as the selected conversation.
     * @param filename The filename associated with the selected conversation.
     */
    private SelectedConversation(Conversation conversation, String filename){
        currentConversation=conversation;
        currentFilename=filename;
    }

    /**
     * Retrieves the current instance of SelectedConversation.
     *
     * @return The current instance of SelectedConversation, or {@code null} if no conversation is selected.
     */
    public static SelectedConversation getInstance(){
        return _instance;
    }

    /**
     * Creates or updates the singleton instance with the specified conversation and filename.
     *
     * @param conversationToUse The conversation to set as the current selected conversation.
     * @param filename The filename associated with the conversation.
     */
    public static void getInstance(Conversation conversationToUse,String filename){
        _instance=new SelectedConversation(conversationToUse,filename);
    }

    /**
     * Closes the current session by nullifying the singleton instance, effectively deselecting the conversation.
     */
    public static void closeSession(){
        _instance=null;
    }

    /**
     * Retrieves the currently selected conversation.
     *
     * @return The conversation currently selected, or {@code null} if no conversation is selected.
     */
    public Conversation getCurrentConversation() {
        return currentConversation;
    }

    /**
     * Retrieves the filename associated with the currently selected conversation.
     *
     * @return The filename of the selected conversation, or {@code null} if no conversation is selected.
     */
    public String getCurrentFilename() {
        return currentFilename;
    }
}
