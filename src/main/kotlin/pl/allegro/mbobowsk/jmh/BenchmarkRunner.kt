package pl.allegro.mbobowsk.jmh

class BenchmarkRunner {
	companion object {

		private val logger = logger()

		@JvmStatic
		fun main(args: Array<String>) {
			logger.info("main")
			org.openjdk.jmh.Main.main(args)
		}
	}
}
