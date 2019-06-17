package xyz.alifenga.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import xyz.alifenga.po.DemoObj;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * HttpMessageConverter是用来处理request和respone里的数据的
 * 通过继承AbstractHttpMessageConverter自定义HttpMessageConverter
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    /**
     * 新建一个我们自定义的媒体类型,application/x-wisely
     */
    public MyMessageConverter() {
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
    }

    /**
     * 表明本HttpMessageConverter只处理DemoObj这个类
     *
     * @param aClass
     * @return
     */
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    /**
     * 重写readInternal方法,处理请求的数据,代码表明我们处理由"-"隔开的数据,并转出DemoObj的对象
     *
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(new Long(tempArr[0]), tempArr[1]);
    }

    /**
     * 重写writeInternal,处理如何输出数据到respone,此例中,我们在原样输出前面加上"hello"
     *
     * @param obj
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + obj.getId() + "-" + obj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
