import { Router } from "express"
import knex from "../database/knex";
import { z } from "zod";
import { hash } from "bcryptjs";

const router = Router();

router.get("/", async (req, res) => {

})