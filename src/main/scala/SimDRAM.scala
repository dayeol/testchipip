package testchipip

import chisel3._
import junctions.{NastiIO, NastiKey}
import cde.Parameters
import uncore.agents.CacheBlockBytes

class SimDRAM(implicit p: Parameters) extends BlackBox {
  val io = IO(new Bundle {
    val clock = Input(Clock())
    val reset = Input(Bool())
    val axi = Flipped(new NastiIO())
  })

  val nastiKey = p(NastiKey)

  require(nastiKey.idBits == 5)
  require(nastiKey.addrBits == 32)
  require(nastiKey.dataBits == 64)
  require(p(CacheBlockBytes) == 64)
}
