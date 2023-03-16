public class RAM {
    private byte[] memory;
    private int size;

    public RAM(int size) {
        this.size = size;
        memory = new byte[size];
    }

    public int getSize() {
        return size;
    }

    public byte read(int address) {
        return memory[address];
    }

    public void write(int address, byte data) {
        memory[address] = data;
    }

    public void refresh(byte[] data) {
        if (data.length <= memory.length) {
            System.arraycopy(data, 0, memory, 0, data.length);
        }
    }

    public byte[] loadProgram(int startAddress, int length) {
        byte[] program = new byte[length];
        if (startAddress + length <= memory.length) {
            System.arraycopy(memory, startAddress, program, 0, length);
        }
        return program;
    }
}
