/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'XM1000Msg'
 * message type.
 */

public class XM1000Msg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 20;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 7;

    /** Create a new XM1000Msg of size 20. */
    public XM1000Msg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new XM1000Msg of the given data_length. */
    public XM1000Msg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new XM1000Msg with the given data_length
     * and base offset.
     */
    public XM1000Msg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new XM1000Msg using the given byte array
     * as backing store.
     */
    public XM1000Msg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new XM1000Msg using the given byte array
     * as backing store, with the given base offset.
     */
    public XM1000Msg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new XM1000Msg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public XM1000Msg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new XM1000Msg embedded in the given message
     * at the given base offset.
     */
    public XM1000Msg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new XM1000Msg embedded in the given message
     * at the given base offset and length.
     */
    public XM1000Msg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <XM1000Msg> \n";
      try {
        s += "  [nodeid=0x"+Long.toHexString(get_nodeid())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [temp=0x"+Long.toHexString(get_temp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [hum=0x"+Long.toHexString(get_hum())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [light=0x"+Long.toHexString(get_light())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [batt=0x"+Long.toHexString(get_batt())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: nodeid
    //   Field type: long, unsigned
    //   Offset (bits): 0
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'nodeid' is signed (false).
     */
    public static boolean isSigned_nodeid() {
        return false;
    }

    /**
     * Return whether the field 'nodeid' is an array (false).
     */
    public static boolean isArray_nodeid() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'nodeid'
     */
    public static int offset_nodeid() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'nodeid'
     */
    public static int offsetBits_nodeid() {
        return 0;
    }

    /**
     * Return the value (as a long) of the field 'nodeid'
     */
    public long get_nodeid() {
        return (long)getUIntBEElement(offsetBits_nodeid(), 32);
    }

    /**
     * Set the value of the field 'nodeid'
     */
    public void set_nodeid(long value) {
        setUIntBEElement(offsetBits_nodeid(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'nodeid'
     */
    public static int size_nodeid() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'nodeid'
     */
    public static int sizeBits_nodeid() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: temp
    //   Field type: long, unsigned
    //   Offset (bits): 32
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'temp' is signed (false).
     */
    public static boolean isSigned_temp() {
        return false;
    }

    /**
     * Return whether the field 'temp' is an array (false).
     */
    public static boolean isArray_temp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'temp'
     */
    public static int offset_temp() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'temp'
     */
    public static int offsetBits_temp() {
        return 32;
    }

    /**
     * Return the value (as a long) of the field 'temp'
     */
    public long get_temp() {
        return (long)getUIntBEElement(offsetBits_temp(), 32);
    }

    /**
     * Set the value of the field 'temp'
     */
    public void set_temp(long value) {
        setUIntBEElement(offsetBits_temp(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'temp'
     */
    public static int size_temp() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'temp'
     */
    public static int sizeBits_temp() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: hum
    //   Field type: long, unsigned
    //   Offset (bits): 64
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'hum' is signed (false).
     */
    public static boolean isSigned_hum() {
        return false;
    }

    /**
     * Return whether the field 'hum' is an array (false).
     */
    public static boolean isArray_hum() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'hum'
     */
    public static int offset_hum() {
        return (64 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'hum'
     */
    public static int offsetBits_hum() {
        return 64;
    }

    /**
     * Return the value (as a long) of the field 'hum'
     */
    public long get_hum() {
        return (long)getUIntBEElement(offsetBits_hum(), 32);
    }

    /**
     * Set the value of the field 'hum'
     */
    public void set_hum(long value) {
        setUIntBEElement(offsetBits_hum(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'hum'
     */
    public static int size_hum() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'hum'
     */
    public static int sizeBits_hum() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: light
    //   Field type: long, unsigned
    //   Offset (bits): 96
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'light' is signed (false).
     */
    public static boolean isSigned_light() {
        return false;
    }

    /**
     * Return whether the field 'light' is an array (false).
     */
    public static boolean isArray_light() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'light'
     */
    public static int offset_light() {
        return (96 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'light'
     */
    public static int offsetBits_light() {
        return 96;
    }

    /**
     * Return the value (as a long) of the field 'light'
     */
    public long get_light() {
        return (long)getUIntBEElement(offsetBits_light(), 32);
    }

    /**
     * Set the value of the field 'light'
     */
    public void set_light(long value) {
        setUIntBEElement(offsetBits_light(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'light'
     */
    public static int size_light() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'light'
     */
    public static int sizeBits_light() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: batt
    //   Field type: long, unsigned
    //   Offset (bits): 128
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'batt' is signed (false).
     */
    public static boolean isSigned_batt() {
        return false;
    }

    /**
     * Return whether the field 'batt' is an array (false).
     */
    public static boolean isArray_batt() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'batt'
     */
    public static int offset_batt() {
        return (128 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'batt'
     */
    public static int offsetBits_batt() {
        return 128;
    }

    /**
     * Return the value (as a long) of the field 'batt'
     */
    public long get_batt() {
        return (long)getUIntBEElement(offsetBits_batt(), 32);
    }

    /**
     * Set the value of the field 'batt'
     */
    public void set_batt(long value) {
        setUIntBEElement(offsetBits_batt(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'batt'
     */
    public static int size_batt() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'batt'
     */
    public static int sizeBits_batt() {
        return 32;
    }

}
