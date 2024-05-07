import { Quiz } from "./quiz";

export class Question {
    quesId!:Number;
    question!:String;
    image!:String;
    option1!:String;
    option2!:String;
    option3!:String;
    option4!:String;
    answer!:String;
    givenAnswer!:String;
    quiz:Quiz=new Quiz();
}
