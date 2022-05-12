import { Link } from "react-router-dom";
import base from "./Base.module.css"
import Stars2 from "../components/layout/Stars2"
import Navbar from "../components/layout/Navbar";


function Clinic(){

    return (
        <>
        <Navbar />
        <Stars2 />
        <div className={base.container}> 
            <h1>클리닉</h1>
         인공지능 대화 
         아 완전 귀찮은데 오늘 꼭 한다
        </div>
        </>
    );
}

export default Clinic;