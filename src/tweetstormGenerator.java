
import java.util.ArrayList;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.List;
import twitter4j.Twitter;
import twitter4j.Status;

public class tweetstormGenerator
{
	public static void main(String[] args) throws TwitterException{

		ConfigurationBuilder cf = new ConfigurationBuilder();

		cf.setDebugEnabled(true)
			.setOAuthConsumerKey("EPINOmoZrP12DET2FJDIAj1pJ")
			.setOAuthConsumerSecret("2Jr01uaTuKUVLqkk4NVIzT8D9P7EWo5DfVqejbgsUKZUYhbGlO")
			.setOAuthAccessToken("816743719143698433-pLpzyZCnbDphHHX6PrtQeMM5dQ0NyBl")
			.setOAuthAccessTokenSecret("g9qz34R2HMyc3KPz77tltNcqOUYcSI3TpHgV7brOfCDmf");

			TwitterFactory tf = new TwitterFactory(cf.build());
			Twitter twitter = tf.getInstance();

		if(args.length != 0){
			int textCharacters = countTextCharacters(args);
			System.out.println(textCharacters);

			if(textCharacters < 12000){

				String [] text = args;
				ArrayList<String> tweets = transformToTweets(text);
				tweets = insertIndexTweets(tweets);

				for(int i = tweets.size()-1; i >= 0;i--){
					Status status = twitter.updateStatus(tweets.get(i));
					int indexForTerminal = i - tweets.size();

		    	System.out.println("Tuíte realizado com sucesso: " + " [" + status.getText() + "].");
				}

			}else{
				System.out.println("Erro, tamanho do texto deve ser menor do que 12.000 caracteres."+
				"Tamanho inserido: " + textCharacters);
			}

		}else{
			System.out.println("Erro, nenhum argumento detectado.");
		}

	}

	public static int countTextCharacters(String[] args){

		int textCharacters = 0;

		for(int i = 0 ; i < args.length; i++){
			textCharacters += args[i].length();
		}
		return textCharacters;
	}

	public static ArrayList<String> insertIndexTweets(ArrayList<String> tweets){
		ArrayList<String> tweetsWithIndex = new ArrayList<String> ();

		for(int i = 0 ; i < tweets.size();i++){
			tweetsWithIndex.add(i+1 + "/" + tweets.size()+ tweets.get(i));
		}
		return tweetsWithIndex;
	}

	public static ArrayList<String> transformToTweets(String[] text){

		ArrayList<String> tweets = new ArrayList<String> ();
		String tweetText = "";

		for(int i = 0; i<text.length;){

			if(tweetText.length() + text[i].length() < 132){
				tweetText = tweetText.concat(" " + text[i]);
			}else{
				tweets.add(tweetText);
				tweetText = "";
				i--;
			}
			i++;
		}

		return tweets;

	}

}
