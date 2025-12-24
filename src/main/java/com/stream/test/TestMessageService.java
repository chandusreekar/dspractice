package com.stream.test;

public class TestMessageService{
	public static void main(String[] args) {
		Notification obj = new Notification(new MessageService() {
			
			@Override
			public void sendMessage(String message) {
				// TODO Auto-generated method stub
				
			}
		});
		obj.alert("message");
	}
}
interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class Notification {
    private MessageService service;

    public Notification(MessageService service) {
        this.service = service;
    }

    public void alert(String msg) {
        service.sendMessage(msg);
    }
}


