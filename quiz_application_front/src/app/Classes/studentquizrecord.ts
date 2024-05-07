import { Quiz } from "./quiz";
import { User } from "./user";

export class Studentquizrecord {
    recordId!: number;
  marksGot!: number;
  correctAnswer!: number;
  attempted!: number;
  date!: Date;
  user!: User;
  quiz!: Quiz;
}
