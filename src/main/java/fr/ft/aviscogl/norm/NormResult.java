package fr.ft.aviscogl.norm;

import java.util.Optional;

public class NormResult
{

    private NormType type;
    private String message;
    private int line = 1;
    private int offset = -1;

    public NormType getType()
    {
        return type;
    }

    public void setType(NormType type)
    {
        this.type = type;
    }

    public int getLine()
    {
        return line;
    }

    public void setLine(int line)
    {
        this.line = line;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "NormResult{" +
                "type=" + type +
                ", message='" + message + '\'' +
                ", line=" + line +
                ", offset=" + offset +
                '}';
    }
}
