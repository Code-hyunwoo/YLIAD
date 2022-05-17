import { Link } from "react-router-dom";
import Styles from "./Firefly.module.css";
import base from "../../routes/Base.module.css";
import moon from "../../assets/images/lobby/moon.png";
import star from "../../assets/images/lobby/star.png";
import star2 from "../../assets/images/lobby/star2.png";
import star3 from "../../assets/images/lobby/star3.png";
import star4 from "../../assets/images/lobby/star4.png";
import star5 from "../../assets/images/lobby/star5.png";
import star6 from "../../assets/images/lobby/star6.png";
import firefly from "../../assets/images/lobby/firefly_move.gif";
import basictree1 from "../../assets/images/lobby/basictree1.png";
import basictree2 from "../../assets/images/lobby/basictree2.png";
import bubbletree from "../../assets/images/lobby/bubbletree.png";
import ad from "../../assets/images/adCape_move_left2.gif";
import ground from "../../assets/images/lobby/ground4.png";
import { BrowserView, MobileView } from 'react-device-detect';


function Firefly(){

    return (
        <>
            <BrowserView>
                <div className={base.container} >
                    <img src={moon} className={Styles.moon} alt="moon"/>
                    {/* <img src={star} className={Styles.star1} alt="star"/> */}
                    {/* <img src={star2} className={Styles.star2} alt="star"/> */}
                    {/* <img src={star3} className={Styles.star3} alt="star"/> */}
                    {/* <img src={star4} className={Styles.star4} alt="star"/> */}
                    {/* <img src={star5} className={Styles.star5} alt="star"/> */}
                    {/* <img src={star6} className={Styles.star6} alt="star"/> */}
                    <img src={firefly} className={Styles.firefly} alt="firefly"></img>
                    <img src={basictree1} className={Styles.basictree1} alt="basictree1"></img>

                    <img src={ad} className={Styles.ad} alt="ad"/>
                    <img src={ground} className={Styles.ground} alt="ground"></img>
                    {/* <img src={ground2} className={Styles.ground} alt="ground"></img> */}
                </div>
            </BrowserView>
            <MobileView>
                <div className={base.container}>
                    <img src={moon} className={Styles.moonM} alt="moon"/>
                    <img src={star} className={Styles.star1M} alt="star"/>
                    <img src={star2} className={Styles.star2M} alt="star"/>
                    <img src={star3} className={Styles.star3M} alt="star"/>
                    <img src={star4} className={Styles.star4M} alt="star"/>
                    <img src={star5} className={Styles.star5M} alt="star"/>
                    <img src={star6} className={Styles.star6M} alt="star"/>
                    
                    <img src={ground} className={Styles.groundM} alt="ground"></img>
                    {/* <img src={ground2} className={Styles.ground} alt="ground"></img> */}
                </div>
            </MobileView>
        </>
    );
}

export default Firefly;