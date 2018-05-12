import main.scala.Main
import org.scalatest._

import scala.collection.immutable

class MainTests extends FlatSpec with Matchers {



  it should "getVectMul equal getVectMulTailrec" in {

    val vector1 = Vector[Int](-12, -13, 3, 25, -3, 1, 2, -5, 12, -11)
    val vector2 = Vector[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    assert(Main.getVectMul(vector1, vector2) === Main.getVectMulTailrec(vector1, vector2))

  }



  it should "getPosList equal getPosListTailrec" in {

    val listOfNumbers = List[Int](12, -13, 3, -25, -3, 1, 2, -5, 12, 11)

    assert(Main.getPosList(listOfNumbers) === Main.getPosListTailrec(listOfNumbers))

  }



  it should "Multiplied vectors" in {

    val vect1 = Vector[Int](3, -4, -5)
    val vect2 = Vector[Int](0, 6, -12)

    Main.getVectMul(vect1, vect2) should be (immutable.Vector(0, -24, 60))
  }



  it should "Multiply empty vectors" in {

    val vect1 = Vector[Int]()
    val vect2 = Vector[Int]()

    Main.getVectMul(vect1, vect2) should be (immutable.Vector())

  }



  it should "Multiplied vectors tailrec" in {

    val vect1 = Vector[Int](3, -4, -5)
    val vect2 = Vector[Int](0, 6, -12)

    Main.getVectMulTailrec(vect1, vect2) should be (immutable.Vector(0, -24, 60))

  }



  it should "Multiply empty vectors tailrec" in {

    val vect1 = Vector[Int]()
    val vect2 = Vector[Int]()

    Main.getVectMulTailrec(vect1, vect2) should be (immutable.Vector())

  }



  it should "Positive elements of list" in {

    val listOfNumbers = List[Int](12, -13, 3, -25, -3, 1, 2, -5, 12, 11)

    Main.getPosList(listOfNumbers) should be (immutable.List(12, 3, 1, 2, 12, 11))
  }



  it should "Positive elements of list(all negative)" in {

    val listOfNumbers = List[Int](-12, -13, -3, -25, -3, -1, -2, -5, -12, -11)

    Main.getPosList(listOfNumbers) should be (List())

  }

  it should "Positive elements of list(empty list)" in {

    val listOfNumbers = List[Int]()

    Main.getPosList(listOfNumbers) should be (List())

  }

  it should "Positive elements of list tailrec" in {

    val listOfNumbers = List[Int](12, -13, 3, -25, -3, 1, 2, -5, 12, 11)

    Main.getPosListTailrec(listOfNumbers) should be (immutable.List(12, 3, 1, 2, 12, 11))
  }



  it should "Positive elements of list(all negative) tailrec" in {

    val listOfNumbers = List[Int](-12, -13, -3, -25, -3, -1, -2, -5, -12, -11)

    Main.getPosListTailrec(listOfNumbers) should be (List())

  }

  it should "Positive elements of list(empty list) tailrec" in {

    val listOfNumbers = List[Int]()

    Main.getPosListTailrec(listOfNumbers) should be (List())

  }
}