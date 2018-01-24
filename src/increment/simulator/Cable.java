package increment.simulator;

/**
 * A cable. A cable holds several bits on it. A cable has a width indicating how many bits
 * it is holding. 
 * 
 * @author Xu Ke
 *
 */
public abstract class Cable {
		/**
		 * replace cable value with another. Note that the input should share the same 
		 * width with this one.
		 * @param input
		 */
		public void assign(Cable input) {
			if (input == null) return;
			if (getWidth() < input.getWidth())
				throw new IllegalStateException("Connecting wrong cables together.");
			for (int i = 0; i < getWidth(); ++i) {
				putBit(i, input.getBit(i));
			}
		}
		/**
		 * replace part of cable value with another. 
		 * @param offset
		 * @param input
		 * @param inputOffset
		 * @param length
		 */
		public void partialAssign(int offset, Cable input, int inputOffset, int length) {
			if (input == null) return;
			while (offset < getWidth() && length > 0 && inputOffset < input.getWidth()) {
				putBit(offset, input.getBit(inputOffset));
				offset += 1;
				inputOffset += 1;
				length -= 1;
			}
		}
		/**
		 * Returns cable width.
		 * @return cable width
		 */
		public abstract int getWidth();
		/**
		 * Returns value at a specific bit
		 * @param bitPos Position of the bit (0 based)
		 * @return
		 */
		public abstract boolean getBit(int bitPos);
		/**
		 * Sets a bit to a specific value
		 * @param bitPos
		 */
		public abstract void putBit(int bitPos, boolean val);
		/**
		 * Turns cable value into an integer.
		 * If cable width is larger than 64, behavior is undefined.
		 * @return
		 */
		public long toInteger() {
			long result = 0;
			for (int i = 0; i < getWidth(); ++i)
			{
				result <<= 1;
				if (getBit(i))
					result += 1;
			}
			return result;
		}
		/**
		 * Put an integer into the cable.
		 * Uses only low ```width``` bits.
		 * @param value
		 */
		public void putValue(long value) {
			for (int i = getWidth(); i > 0; --i)
			{
				putBit(i - 1, (value & 1) == 1);
				value >>= 1;
			}
		}
		/**
		 * Sets all bits in cable to 0.
		 */
		public void setZero(){
			for (int i = 0; i < getWidth(); ++i)
				putBit(i, false);
		}
		/**
		 * Gets a readable form
		 */
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("Cable value: ");
			sb.append(toInteger());
			return sb.toString();
		}
}
