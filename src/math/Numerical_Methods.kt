package math

import java.lang.Exception

/*
Class with different mathimatical methods
for finding solution to functions, integrate, etc.
*/

enum class IntegrateType {
    TRAPEZE,
    RECTANGLE,
    SIMPSON
    //and others
}

class Numerical_Methods {

    companion object {
        fun Integrate(function : (Double) -> Double, a : Double, b : Double, type : IntegrateType) : Double {
            return when(type) {
                IntegrateType.TRAPEZE -> Integral_trapeze(function, a, b)
                else -> throw Exception("Integrate method is unavailable")
            }
        }

        private fun Integral_trapeze(function : (Double) -> Double, a: Double, b: Double, n: Double = 20.0, e: Double = 0.00001): Double {
            var sum = 0.0
            val h: Double

            h = (b - a) / (1.0 * n)
            var i = 1
            while (i < n) {
                sum += function(a + i * h)
                ++i
            }
            sum += (function(a) + function(b)) / 2
            sum *= h
            return sum
        }


        private fun horda( function : (Double) -> Double, a: Double, b: Double, e: Double = 0.00001): Double {
            var a = a
            var b = b
            b = a - (a - b) * function(a) / (function(a) - function(b))
            while (Math.abs(b - a) > e) {
                a = b - (b - a) * function(b) / (function(
                    b
                ) - function(a))
            }
            return b
        }

        private fun newtone(`fun`: Function, a: Double, b: Double, e: Double = 0.00001): Double {
            var xn: Double
            var x0: Double

            if (`fun`.Calculate(a) * `fun`.CFunction().CFunction().Calculate(a) > 0)
                x0 = a // для выбора начальной точки проверяем f(x0)*d2f(x0)>0 ?
            else
                x0 = b

            xn = x0 - `fun`.Calculate(x0) / `fun`.CFunction().Calculate(x0) // считаем первое приближение

            while (Math.abs(x0 - xn) > e)
            // пока не достигнем необходимой точности, будет продолжать вычислять
            {
                x0 = xn
                xn = x0 - `fun`.Calculate(x0) / `fun`.CFunction().Calculate(x0) // непосредственно формула Ньютона
                //cout<<++i<<"-th iteration = "<<xn<<"\n";
            }
            return xn
        }
    }
}
