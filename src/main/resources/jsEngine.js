
function invoke(methodname,args){
	var result = '-3';
	methodname = methodname+'';//转换成字符串
	switch(methodname){
	case 'HELLO':
		if(!check(args,1)){
			result = sayHello(args[0]);
		}
		break;
	case 'INCREMENT':
		if(!check(args,2)){
			result = increment(args[0],args[1]);
		}else{
			result = '-1'
		}
			break;
	default:
		result = '-2';
	}
	return result;
}

/**
 * 参数校验
 * @param param
 * @param size
 * @returns {Boolean}
 */
function check(param,size){
	if(param == null  || param.length < size){
		return true;
	}
	return false;
}

function sayHello(name){
	if(name == null || name == ''){
		return "-1";
	}
	return "Hello,"+name;
}


function increment(i,j){
	return parseInt(i)+parseInt(j);
}

