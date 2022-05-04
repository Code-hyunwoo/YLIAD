import { Link } from "react-router-dom";
import base from "./Base.module.css"
import Stars2 from "../components/layout/Stars2"


function Setting(){

    return (
        <>
        <Stars2 />
        <div className={base.container}> 
            <h1>환경설정</h1>

            <Link to="/lobby"><button> 로비로 이동 </button></Link>
            <Link to="/theme"><button> 테마 변경 </button></Link>
            <Link to="/bgm"><button> BGM 변경 </button></Link>
            <Link to="/fontchange"><button> 폰트 변경 </button></Link>
            <Link to="/passwordchange"><button> 비밀번호 변경 </button></Link>
            <Link to="/alarm"><button> 알림기능 </button></Link>
        </div>
        </>
    );
}

export default Setting;