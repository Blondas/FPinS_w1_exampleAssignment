package example

import java.util.NoSuchElementException

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * A test suite is created by defining a class which extends the type
 * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 *
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
 @RunWith(classOf[JUnitRunner])
  class ListsSuite extends FunSuite {
 
  /**
   * Tests are written using the `test` operator which takes two arguments:
   *
   * - A description of the test. This description has to be unique, no two
   *   tests can have the same description.
   * - The test body, a piece of Scala code that implements the test
   *
   * The most common way to implement a test body is using the method `assert`
   * which tests that its argument evaluates to `true`. So one of the simplest
   * successful tests is the following:
   */
  ignore("one plus one is two")(assert(1 + 1 == 2))

  /**
   * In Scala, it is allowed to pass an argument to a method using the block
   * syntax, i.e. `{ argument }` instead of parentheses `(argument)`.
   *
   * This allows tests to be written in a more readable manner:
   */
  ignore("one plus one is three?") {
    assert(1 + 1 == 3) // This assertion fails! Go ahead and fix it.
  }

  /**
   * One problem with the previous (failing) test is that ScalaTest will
   * only tell you that a test failed, but it will not tell you what was
   * the reason for the failure. The output looks like this:
   *
   * {{{
   *    [info] - one plus one is three? *** FAILED ***
   * }}}
   *
   * This situation can be improved by using a special equality operator
   * `===` instead of `==` (this is only possible in ScalaTest). So if you
   * run the next test, ScalaTest will show the following output:
   *
   * {{{
   *    [info] - details why one plus one is not three *** FAILED ***
   *    [info]   2 did not equal 3 (ListsSuite.scala:67)
   * }}}
   *
   * We recommend to always use the `===` equality operator when writing tests.
   */
  ignore("details why one plus one is not three") {
    assert(1 + 1 === 2) // Fix me, please!
  }

  /**
   * In order to test the exceptional behavior of a methods, ScalaTest offers
   * the `intercept` operation.
   *
   * In the following example, we test the fact that the method `intNotZero`
   * throws an `IllegalArgumentException` if its argument is `0`.
   */
  ignore("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }


  /**
   * Now we finally write some tests for the list functions that have to be
   * implemented for this assignment. We fist import all members of the
   * `List` object.
   */
  import Lists._


  /**
   * We only provide two very basic tests for you. Write more tests to make
   * sure your `sum` and `max` methods work as expected.
   *
   * In particular, write tests for corner cases: negative numbers, zeros,
   * empty lists, lists with repeated elements, etc.
   *
   * It is allowed to have multiple `assert` statements inside one test,
   * however it is recommended to write an individual `test` statement for
   * every tested aspect of a method.
   */
  test("sum of a few numbers") {
    assert(sum(List(1,2,0)) === 3)
  }

  test("sum of a empty list") {
    assert(sum(List()) === 0)
  }

  test("sum of one element list") {
    assert(sum(List(1)) === 1)
  }

  test("sum of same elements") {
    assert(sum(List(3,3,3)) === 9)
  }

  test("sum of negative elements") {
    assert(sum(List(-3,-1,-5)) === -9)
  }


  test("max of a few numbers") {
    assert(max(List(3, 7, 2)) === 7)
  }

  test("max of a empty list") {
    intercept[NoSuchElementException] {
      max(List())
    }
  }

  test("max of same elements - zeroes") {
      assert(max(List(0,0,0,0)) === 0)
  }

  test("max of same elements - not zeroes") {
    assert(max(List(3,3,3)) === 3)
  }

  test("max of negative elements") {
    assert(max(List(-2,-3,-5)) === -2)
  }

  test("max of few numbers with negatives") {
    assert(max(List(-2,3,-5,7)) === 7)
  }

}
