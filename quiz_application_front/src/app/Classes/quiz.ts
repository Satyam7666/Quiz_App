import { Category } from "./category";

export class Quiz {

    quizId!:Number;
    title!:String;
    description!:String;
    maxMark!:any;
    numberOfquestion!:any;
    
    active!:true;
    category:Category= new Category;
}
