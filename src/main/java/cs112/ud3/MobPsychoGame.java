package cs112.ud3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.net.URL;
import javafx.scene.control.Label;

public class MobPsychoGame extends Application {

    private MediaPlayer mediaPlayer;
    private VBox root;

    @Override
    public void start(Stage primaryStage) {
        root = new VBox(10);
        root.setSpacing(10.0);
        primaryStage.setTitle("Mob Psycho 100 Game Simulator: Cooking Edition!");

        playAudio();

        showIntroduction(primaryStage);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createWrappedLabel(String text, double width) {
        Label label = new Label(text);
        label.setWrapText(true);
        label.setPrefWidth(width);
        label.setMaxWidth(width);
        label.setStyle("-fx-font-size: 14px; -fx-padding: 5px;");
        return label;
    }
    

    private void showIntroduction(Stage primaryStage) {

        root.getChildren().clear();

        Label introLabel = createWrappedLabel(
                "Your name is Kageyama Shigeo, also nicknamed 'Mob'. " +
                        "You are a 14-year-old psychic with extraordinary telekinetic powers that have gotten out of control and hurt others in the past. " +
                        "After an incident with your younger brother, you seek guidance from fellow 'psychic' Reigen Arataka (who is actually a self-proclaimed psychic with no spiritual or telekinetic powers of any kind and miraculously runs an exorcism business... somehow but that's not the point of today's game!) " +
                        "Today is October 10th, also known as Master Reigen’s 28th birthday! " +
                        "You are unsure of what to buy him considering your recent pay of 300 yen a day ($1.98), but hey, it’s Reigen’s fault you’re broke so he should be grateful you’re even making something! " +
                        "So what better than making his favorite food: Ramen!! " +
                        "Together with the help of Dimple, a green poo-like evil spirit who is more of a pet than a spirit who totally didn’t try to take over your powers to create a worldwide, hypnotic religion (yup totally sane things in your totally normal life as a boring middle schooler), you will make Reigen the best ramen he’s ever had!", 550
        );

        Button introButton = new Button("Start the Game");
        introButton.setOnAction(e -> startGame());


        root.getChildren().addAll(introLabel, introButton);
    }


    private void startGame() {
        root.getChildren().clear();

        Label introLabel = createWrappedLabel("Let's start the game!", 550);
        root.getChildren().add(introLabel);
        GameChoice[] choices = {
                new SimpleChoice("Q1: Dimple: So Shigeo, are we really making him Ramen… in his office… for his birthday gift?\n", () -> displayQ1())
        };

        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(100);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayQ1() {
        root.getChildren().clear();
        Label q1Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(q1Label);
        GameChoice[] choices = { // abstract class & SimpleChoice is the concrete class
                new SimpleChoice("A1: Yes Dimple, how many times are you going to ask? We already bought all the ingredients and Master doesn’t get back for another two hours, we can do this!", () -> displayA1()),
                new SimpleChoice("A2: Are you saying we shouldn’t make Ramen? But then that means we have to quit the “Mob Psycho 100 Game Simulator: Cooking Edition!” Would you really like that?", () -> displayA5()),
                //new SimpleChoice("", () -> displayA5()), (custom exception)
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(100);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }
/*
public class SimpleChoice extends GameChoice {
    public SimpleChoice(String choiceText, Runnable action) {
        super(choiceText, action);
    }

    @Override
    public void performAction() throws InvalidChoiceException {
        if (getChoiceText().isEmpty()) {
            throw new InvalidChoiceException("Choice cannot be empty.");
        }
        System.out.println("Performing action for: " + getChoiceText());
        action.run();
    }
}
 */ // continuation of custom exception
    /*
     button.setOnAction(e -> {
            try {
                choice.performAction();
            } catch (InvalidChoiceException ex) {

                System.out.println("Error: " + ex.getMessage());
            }
        });

        root.getChildren().add(button);
    }
}
     */ // continuation of custom exception

    private void displayA1() {
        root.getChildren().clear();
        Label a1Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a1Label);
        GameChoice[] choices = {
                new SimpleChoice("A3:(Dimple) Alright, alright so what do we do first!", () -> displayA3()),
                new SimpleChoice("A4:(Dimple) I don’t know about this Shigeo, you’re going to start a fire hazard or probably food poison the guy...ha, serves a fraud like him right though I don't really want to be ghost buddies with him...", () -> displayA4())
        };

        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(100);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

private void displayA4() {
    root.getChildren().clear();
    Label a4Label =  createWrappedLabel("Choose your answer:", 550);
    root.getChildren().add(a4Label);
    GameChoice[] choices = {
            new SimpleChoice("A9:Dimple don’t talk about Master Reigen this way! And I know how to cook (you don’t)! I have watched some cooking videos (you haven't)! And everything will be fine (it won't)! Let's get back to cooking!", () -> displayA9()),
            new SimpleChoice("A10: You start to panic as you realize the evil spirit might be right…I guess I can try again next year...", () -> endGame())
    };
    for (GameChoice choice : choices) {
        Button button = new Button();
        Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
        button.setGraphic(buttonLabel);
        button.setMaxWidth(550);
        button.setPrefHeight(100);
        button.setOnAction(e -> choice.performAction());
        root.getChildren().add(button);
    }
}



    private void displayA3() {
        root.getChildren().clear();
        Label a3Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a3Label);
        GameChoice[] choices = {
                new SimpleChoice("A7: Hmm, it says to bring 2 cups of water to a boil, add the dry noodles, cook for 3 minutes, add ramen soup base, stir, and then serve! Doesn’t sound too hard!", () -> displayA7()),
                new SimpleChoice("A8: As you’re about to answer Dimple, you spill the boiling hot water on your phone which obviously stops working so you totally make an adult decision to put the phone in some non-existent rice and wait for Master to get back and forget about the gift but SIKE you’re still playing and missed your opportunity to quit!!! So you make a very mature decision and say: Oh no my phone! Hmm… looks we have less than an hour now, let’s just go with the flow! I remember seeing a cooking video on 5 minute crafts, I think!", () -> displayA8())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(140);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayA5() {
        root.getChildren().clear();
        Label a5Label = createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a5Label);
        GameChoice[] choices = {
                new SimpleChoice("A5: (Dimple) Oh wait, you’re right! Well that’s boring, it hasn’t even been a minute since we started the game! Let’s get to it!", () -> displayA3()),
                new SimpleChoice("A6: (Dimple) Shigeo, I think the best gift you’re giving the guy is working for the amount of spare change… that can be found on the ground… PER DAY!! I’m outta here!", () -> endGame())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(100);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayA7() {
        root.getChildren().clear();
        Label a7Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a7Label);
        GameChoice[] choices = {
                new SimpleChoice("A11: You meticulously make the ramen noodles and finish it off with one slice of pork belly because again you’re broke! But who cares!!! He can make his own game simulator and complain about it there >:( \n" +
                        "You hear the sound of the front door open and you place the totally appetizing ramen on his desk and… SURPRISE!! Happy birthday Master Reigen! made you ramen as a gift, I hope you like it! Dimple totally isn’t holding back his laughter from the fear in Reigen’s eyes", () -> displayA15()),
                new SimpleChoice("A12: You mess up and the ramen water overflows onto the floor. It is then that you lock eye contact with Dimple and realize 'yup this was a bad idea' but too late the office is now on fire and you are running outta there with Reigen's safe (can't have him at a loss on his birthday now THAT would be bad!!)", () -> displayA12())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(145);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayA8() {
        root.getChildren().clear();
        Label a8Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a8Label);
        GameChoice[] choices = {
                new SimpleChoice("A13: (Dimple) Oh boy Shigeo, what did I tell you!! This was a bad bad idea!! Here let me take over!",   () -> displayA13()),
                new SimpleChoice("A14: You realize while you’re 10 minutes into this ramen adventure that something isn’t right and the pot is shaking. Maybe Dimple was right. But too late as a fire bursts out and you’re running out there grabbing the essentials.", () -> displayA14())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(140);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayA9() {
        root.getChildren().clear();
        Label a9Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a9Label);
        GameChoice[] choices = {
                new SimpleChoice("A11: You meticulously make the ramen noodles and finish it off with one slice of pork belly because again you’re broke! But who cares!!! He can make his own game simulator and complain about it there >:( \n" +
                        "You hear the sound of the front door open and you place the totally appetizing ramen on his desk and… SURPRISE!! Happy birthday Master Reigen!I made you ramen as a gift, I hope you like it! Dimple totally isn’t holding back his laughter from the fear in Reigen’s eyes", () -> displayA15()),
                new SimpleChoice("A12: You mess up and the ramen water overflows onto the floor. It is then that you lock eye contact with Dimple and realize “yup this was a bad idea” but too late the office is now on fire and you are running outta there with Reigen’s safe (can’t have him at a loss on his birthday now THAT would be bad!!)", () -> displayA16())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(145);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

   /* private void displayA11() {
        root.getChildren().clear();
        Label a11Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a11Label);
        GameChoice[] choices = {
                new SimpleChoice("A15: Reigen smiles warmly accepting his gift, despite questioning why one side of the pork is pitch black and the other is frozen...Thanks Mob, but uh how about I take you out to ramen too haha my treat?", () -> endGame())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(145);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

*/

    private void displayA12() {
        root.getChildren().clear();
        Label a12Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a12Label);
        GameChoice[] choices = {
                new SimpleChoice("A16: As you reach the front of the building, you ignore some concerning explosion sounds and run into a stone-faced Reigen. Oh hi Master Reigen! So I tried making you ramen as a birthday gift but I ended up burning the office down…but don’t worry I made sure to bring the client’s money (you reach to take out what you assumed to be the safe from your school bag but it ends up being the easy ramen packaging… Reigen totally doesn’t faint! Well that’s what you get when you don’t pay minimum wage to your employees, users, please learn from Mob as an example (please don’t))", () -> endGame())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(150);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayA13() {
        root.getChildren().clear();
        Label a13Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a13Label);
        GameChoice[] choices = {
                new SimpleChoice("A17: Dimple meticulously makes the ramen noodles and surprisingly doesn't burn the place down, finishing it off with one slice of pork belly because again you're broke and again it's not your fault! It's the thought that counts these days! I'm pretty sure Reigen's not gonna trust what's in it anyway but who cares!!! He can make his own game simulator and complain about it there >:( You hear the sound of the front door open and you place the totally appetizing ramen on his desk and...SURPRISE!! Happy birthday Master Reigen! I made you ramen as a gift, I hope you like it! Dimple totally isn't holding back his laughter from the fear in Reigen's eyes", () -> displayA15()),
                new SimpleChoice("A18: You both realize while you're 10 minutes into this ramen adventure that something isn't right and the pot is shaking and making noises it shouldn't. Maybe just maybe Dimple was right. But too late as a fire bursts out and you're running out there grabbing the essentials", () -> displayA16())
        };

        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(155);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayA14() {
        root.getChildren().clear();
        Label a14Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a14Label);
        GameChoice[] choices = {
                new SimpleChoice("A16: As you reach the front of the building, you ignore some concerning explosion sounds and run into a stone-faced Reigen. Oh hi Master Reigen! So I tried making you ramen as a birthday gift but I ended up burning the office down…but don’t worry I made sure to bring the client’s money (you reach to take out what you assumed to be the safe from your school bag but it ends up being the easy ramen packaging… Reigen totally doesn’t faint! Well that’s what you get when you don’t pay minimum wage to your employees, users, please learn from Mob as an example (please don’t))", () -> endGame())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(150);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void displayA15() {
        root.getChildren().clear();
        Label a15Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a15Label);
        GameChoice[] choices = {
                new SimpleChoice("A15: Reigen smiles warmly accepting his gift, despite questioning why one side of the pork is pitch black and the other is frozen… Thanks Mob, but uh how about I take you out to ramen too haha my treat? ", () -> endGame())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(150);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }


    private void displayA16() {
        root.getChildren().clear();
        Label a16Label =  createWrappedLabel("Choose your answer:", 550);
        root.getChildren().add(a16Label);
        GameChoice[] choices = {
                new SimpleChoice("A16: As you reach the front of the building, you ignore some concerning explosion sounds and run into a stone-faced Reigen. Oh hi Master Reigen! So I tried making you ramen as a birthday gift but I ended up burning the office down…but don’t worry I made sure to bring the client’s money (you reach to take out what you assumed to be the safe from your school bag but it ends up being the easy ramen packaging… Reigen totally doesn’t faint! Well that’s what you get when you don’t pay minimum wage to your employees, users, please learn from Mob as an example (please don’t))", () -> endGame())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(150);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }







    private void endGame() {
        root.getChildren().clear();
        GameChoice[] choices = {
                new SimpleChoice("Congratulations! You’ve reached an ending. Press restart to play again.", () -> restartGame())
        };
        for (GameChoice choice : choices) {
            Button button = new Button();
            Label buttonLabel = createWrappedLabel(choice.getChoiceText(), 550);
            button.setGraphic(buttonLabel);
            button.setMaxWidth(550);
            button.setPrefHeight(100);
            button.setOnAction(e -> choice.performAction());
            root.getChildren().add(button);
        }
    }

    private void restartGame() {
        showIntroduction((Stage) root.getScene().getWindow());
    }


    private void playAudio() {
        try {

            URL resource = getClass().getResource("/reigen_theme.mp3");
            if (resource == null) {
                throw new IllegalArgumentException("Audio file not found!");
            }
            Media media = new Media(resource.toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (Exception e) {
            System.err.println("Error playing audio: " + e.getMessage());
        }
    }




    public static void main(String[] args) {
        launch(args);
    }


    abstract class GameChoice {
        abstract String getChoiceText();
        abstract void performAction();
    }


    class SimpleChoice extends GameChoice {
        private String choiceText;
        private Runnable action;

        public SimpleChoice(String choiceText, Runnable action) {
            this.choiceText = choiceText;
            this.action = action;
        }

        @Override
        String getChoiceText() {
            return choiceText;
        }

        @Override
        void performAction() {
            action.run();
        }
    }
}
