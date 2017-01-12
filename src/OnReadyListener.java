import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class OnReadyListener extends ListenerAdapter {

	@Override
	public void onReady(ReadyEvent event) {

		try{
			XMLDecoder decoder = new XMLDecoder(
					new BufferedInputStream(
							new FileInputStream(
									new File("data.xml"))));
			MessageListener.setPeople((ArrayList<Person>) decoder.readObject());
			System.out.println(MessageListener.getPeople() + "");
			decoder.close();
			
			
		} catch (IOException o) {
			o.printStackTrace();
		}
	}

}
