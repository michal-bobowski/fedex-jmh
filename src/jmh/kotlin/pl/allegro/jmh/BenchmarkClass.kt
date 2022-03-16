package pl.allegro.jmh

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.random.Random

@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1, timeUnit = TimeUnit.SECONDS, time = 5)
@Measurement(iterations = 5, timeUnit = TimeUnit.SECONDS, time = 5)
open class BenchmarkClass {

    private val N = 10000

    private val testData: ArrayList<Int> = ArrayList()

    @Setup
    fun setup() {
        (0 until N)
            .map { Random.nextInt() }
            .forEach { testData.add(it) }
    }

    @Benchmark
    fun benchmarkBubbleSort() {
        bubbleSort(testData)
    }

    @Benchmark
    fun bechmarkCollectionsSort() {
        testData.sort()
    }

    open fun bubbleSort(arr: ArrayList<Int>) {
        val n = arr.size
        for (i in 0 until n - 1)
            for (j in 0 until n - i - 1)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
    }
}
