package example;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Lambot extends TelegramLongPollingBot {
	
	 //@Override
	public void onUpdateReceived(Update update) {
		// We check if the update has a message and the message has text
	    if (update.hasMessage() && update.getMessage().hasText()) {
	        // Set variables
	        String message_text = update.getMessage().getText();
	        long chat_id = update.getMessage().getChatId();

	        SendMessage message = new SendMessage() // Create a message object object
	                .setChatId(chat_id)
	                .setText(message_text);
	        try {
	            execute(message); // Sending our message object to user
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	//@Override
	public String getBotUsername() {
		// Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "lambot";
	}
	
	@Override
	public String getBotToken() {
		 // Return bot token from BotFather
        return "401859712:AAGkPDW5MFzXL227m2oZfIIuaE8VUuk2z5I";
	}

}
