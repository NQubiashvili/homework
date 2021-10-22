import kotlin.math.sqrt

fun main() {
    /* Point Actions */

    val point1 = Point(2.0F, 3.0F)
    val point2 = Point(-4.0F, -5.0F)

    println(point1.toString())
    println(point1.equals(point2))
    println(point1.movePoint())
    println(point1.calculateDistance(point2))

    /* Fraction Actions */

    val f1 = Fraction(5.0, 6.0)
    val f2 = Fraction(7.0, 8.0)

    println(f1.addition(f2))
    println(f2.subtraction(f2))
}

interface Actions {
    fun addition(other: Any?): Any?
    fun subtraction(other: Any?): Any?
    fun multiply(other: Any?) : Any?
    fun division(other: Any?): Any?
}

class Fraction(n: Double, d: Double): Actions {
    private var numerator: Double = n
    private var denominator: Double = d

    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            if (numerator * other.denominator / denominator == other.numerator) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return "$numerator / $denominator"
    }

    override fun addition(other: Any?): Any? {
        if (other is Fraction) {
            val newDeneminator = denominator * other.denominator
            val newNumerator = (newDeneminator / denominator * numerator) + (newDeneminator / other.denominator * other.numerator)
            val newFraction = Fraction(newNumerator, newDeneminator)
            return newFraction
        }
        return false
    }

    override fun subtraction(other: Any?): Any? {
        if (other is Fraction) {
            val newDeneminator = denominator * other.denominator
            val newNumerator = (newDeneminator / denominator * numerator) - (newDeneminator / other.denominator * other.numerator)
            val newFraction = Fraction(newNumerator, newDeneminator)
            return newFraction
        }
        return false
    }

    override fun multiply(other: Any?): Any? {
        if (other is Fraction) {
            val newNumerator = numerator * other.numerator
            val newDeneminator = denominator * other.denominator
            val newFraction = Fraction(newNumerator, newDeneminator)
            return newFraction
        }
        return false
    }

    override fun division(other: Any?): Any? {
        if(other is Fraction) {
            val newNumerator = numerator * other.denominator
            val newDeneminator = denominator * other.numerator
            val newFraction = Fraction(newNumerator, newDeneminator)
            return newFraction
        }
        return false
    }
}

class Point(private var x: Float, private var y: Float) {
    override fun toString(): String {
        return "$x, $y"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            if (x * other.y / y == x) {
                return true
            }
        }
        return false
    }

    fun movePoint(): String {
        return "${-x}, ${-y}"
    }

    fun calculateDistance(other: Any?): Any {
        if (other is Point) {
            val z = ((x - other.x) * (x - other.x)) + ((y - other.y) * (y - other.y))
            val distance = sqrt(z)
            return "$distance"
        }
        return false
    }
}
