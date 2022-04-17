/**
 * @createTime: 2018年3月5日
 */
package com.swk.demo.test;

/**
 * @classDesc: 类描述: 测试重写hashCode和equals方法
 * @author vico
 * @createTime 2018年3月5日 上午10:46:10
 * @version v1.0.0
 */
public class EqualsHashCodeTest {

	    private int areaCode;
	    private String prefix;
	    private String lineNumber;
	 
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + areaCode;
	        result = prime * result
	                + ((lineNumber == null) ? 0 : lineNumber.hashCode());
	        result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        EqualsHashCodeTest other = (EqualsHashCodeTest) obj;
	        if (areaCode != other.areaCode)
	            return false;
	        if (lineNumber == null) {
	            if (other.lineNumber != null)
	                return false;
	        } else if (!lineNumber.equals(other.lineNumber))
	            return false;
	        if (prefix == null) {
	            if (other.prefix != null)
	                return false;
	        } else if (!prefix.equals(other.prefix))
	            return false;
	        return true;
	    }
	 
	
}
