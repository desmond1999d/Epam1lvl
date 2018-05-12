package main.scala

import scala.annotation.tailrec

object Main {

  def main(args: Array[String]): Unit = {
    val listOfNumbers = List[Int](12, -13, 3, -25, -3, 1, 2, -5, 12, 11)
    println(getPosListTailrec(listOfNumbers))
    println(getPosList(listOfNumbers))
    val vector1 = Vector[Int](-12, -13, 3, 25, -3, 1, 2, -5, 12, -11)
    val vector2 = Vector[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10) //-12 -26 9 100 -15 6 14 -40 -108 -110
    println(getVectMulTailrec(vector1, vector2))
    println(getVectMul(vector1, vector2))
  }

  def getVectMulTailrec(firstVector: Vector[Int], secondVector: Vector[Int]): Vector[Int] = {
    val length = firstVector.length

    @tailrec
    def getVect(resultVector: Vector[Int], firstVector: Vector[Int], secondVector: Vector[Int], sizeOfList: Int): Vector[Int] = {
      if (sizeOfList >= length)
        resultVector
      else
        getVect(resultVector ++ Vector(firstVector(sizeOfList) * secondVector(sizeOfList)), firstVector, secondVector, sizeOfList + 1)
    }

    getVect(Vector(), firstVector, secondVector, 0)
  }

  def getVectMul(firstVector: Vector[Int], secondVector: Vector[Int]) : Vector[Int] = {
    val size = firstVector.length
    val resultVector = Vector()

    def getVect(result: Vector[Int], first: Vector[Int], second: Vector[Int], i: Int): Vector[Int] = {
      if (i == size)
        result
      else
        resultVector ++ getVect(result ++ Vector(first(i)*second(i)), first, second, i+1)
    }

    getVect(Vector(), firstVector, secondVector, 0)
  }

  def getPosListTailrec(list: List[Int]): List[Int] = {
    val size = list.length

    @tailrec
    def buildResultList(resultList: List[Int], list: List[Int], i: Int): List[Int] = {
      if (i == size)
        resultList
      else if (list(i) < 0)
        buildResultList(resultList, list, i + 1)
      else
        buildResultList(resultList ::: List(list(i)), list, i + 1)
    }

    buildResultList(List(), list, 0)
  }

  def getPosList(list: List[Int]): List[Int] = {
    val size = list.length
    val result = List()

    def buildResultList(resultList: List[Int], list: List[Int], i: Int): List[Int] = {
      if (i == size)
        resultList
      else if (list(i) >= 0)
        buildResultList(resultList ::: List(list(i)), list, i + 1)
      else
        result ::: buildResultList(resultList, list, i + 1)
    }

    buildResultList(List(), list, 0)
  }
}